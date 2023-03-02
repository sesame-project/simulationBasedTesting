@ECHO OFF
REM -- Automates cygwin installation for SESAME simulation-based testing framework
REM -- FROM: https://github.com/sesame-project/simulationBasedTesting
REM -- Based on: https://github.com/rtwolf/cygwin-auto-install
REM -- Based on: https://gist.github.com/wjrogers/1016065
 
SETLOCAL
 
REM -- Change to the directory of the executing batch file
CD %~dp0

REM -- Download the Cygwin installer
IF NOT EXIST cygwin-setup.exe (
	ECHO cygwin-setup.exe NOT found! Downloading installer...
	bitsadmin /transfer cygwinDownloadJob /download /priority normal https://cygwin.com/setup-x86_64.exe %CD%\\cygwin-setup.exe
) ELSE (
	ECHO cygwin-setup.exe found! Skipping installer download...
)
 
REM -- Configure our paths
SET SITE=http://mirrorservice.org/sites/sourceware.org/pub/cygwin/
SET LOCALDIR=%CD%
SET ROOTDIR=C:\cygwin64
SET PATH=%ROOTDIR%\bin;%PATH%
 
REM -- These are the packages we will install (in addition to the default packages)
SET PACKAGES=mintty,wget,ctags,diffutils,git,git-completion,git-svn,stgit,mercurial,procps-ng,xterm,psmisc,tar,lynx
REM -- These are necessary for apt-cyg install, do not change. Any duplicates will be ignored.
SET PACKAGES=%PACKAGES%,wget,tar,gawk,bzip2,subversion
 
REM -- More info on command line options at: https://cygwin.com/faq/faq.html#faq.setup.cli
REM -- Do it!
ECHO *** INSTALLING DEFAULT PACKAGES
cygwin-setup --quiet-mode --no-desktop --download --local-install --no-verify -s %SITE% -l "%LOCALDIR%" -R "%ROOTDIR%"
ECHO.
ECHO.
ECHO *** INSTALLING CUSTOM PACKAGES
cygwin-setup -q -d -D -L -X -s %SITE% -l "%LOCALDIR%" -R "%ROOTDIR%" -P %PACKAGES%
 
REM -- Show what we did
ECHO.
ECHO.
ECHO cygwin installation updated
ECHO  - %PACKAGES%
ECHO %ROOTDIR%

%ROOTDIR%\bin\bash.exe -c 'mkdir -p ~/academic/sesame/WP6'
%ROOTDIR%\bin\bash.exe -c 'mkdir -p ~/source/maven-3.9.0'
%ROOTDIR%\bin\bash.exe -c 'cd ~/academic/sesame/WP6 && git clone https://www.github.com/sesame-project/simulationBasedTesting.git'
%ROOTDIR%\bin\bash.exe -c 'cd ~/academic/sesame/WP6 && git checkout windows'
%ROOTDIR%\bin\bash.exe -c 'cd ~/source/maven-3.9.0 && wget https://dlcdn.apache.org/maven/maven-3/3.9.0/binaries/apache-maven-3.9.0-bin.tar.gz'
%ROOTDIR%\bin\bash.exe -c 'cd ~/source/maven-3.9.0 && tar -xvzf apache-maven-3.9.0-bin.tar.gz'

ECHO SESAME installation completed
ENDLOCAL
 
PAUSE
EXIT /B 0
