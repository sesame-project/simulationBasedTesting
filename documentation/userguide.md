# User Guide

## Preparatory Steps 
### Starting Child Eclipse
In order to use the simulation-based testing platform, firstly, the
user should load Eclipse and then invoke a new Eclipse Application, by
right-clicking upon the project
**uk.ac.york.sesame.testing.generator** and selecting *Run As* /
*Eclipse Application*. This will launch a fresh Eclipse instance
under which the SESAME automated code generation plugins are available
(Figure \ref{FIG-RUN-GENERATOR-PROJECT}). (If there is a problem
flagged regarding ``javax.xml.bind'', ignore it). There may be a delay
on the first invocation of this.

![Starting a Child Eclipse by running the generator project](/images/)

### Creating New Project

Create a new Java project - here, we
use \textbf{TTSTestProject}. Create a folder ``models'' in it. When
creating the project, turn off ``Create module-info.java'' at the
bottom of the project dialog.

In order to generate a model for the first time in a newly created
project, it is necessary to register the metamodels. This can be done
by activating the early stage of our wizard, by right-clicking on
``SESAME'' / ``Generate SESAME Code'', as shown in Figure
\ref{FIG-SESAME-WIZARD1}.  Then, click Cancel on the dialog box that
appears.

Next, create an instance of the testing metamodel. To do this, right
click on the folder ``models'' and select ``New'' / ``Other'' /
``Epsilon'' / ``EMF Model'' and set up the parameters as shown in
Figure~\ref{FIG-NEW-MODEL-GENERATION}. Use ``Browse'' to find
``TestingMM'' as the metamodel URI. The model filename can be chosen
to fit the scenario that the users are setting up.

Now users can complete the steps specified in the SESAME
simulation-based testing methodology. When the model is completed, or
when there are any changes to the experiments, right click on the
project, and select ``SESAME'' / ``Generate SESAME Code'' to
regenerate code for metric templates and experiment runners based on
it (Figure \ref{FIG-SESAME-WIZARD}).

\jrhchanged{After this code generation is performed for the first
  time, the project structure must be changed to a Maven
  project. Users should right-click on the project, select
  ``Configure'' / ``Convert to Maven Project''. Then the user should
  right-click and select ``Maven'' / ``Update Project'' to ensure all
  the dependencies are updated.}

An example for the next stage is now given, for setting up an
instantiation of the model model for the KUKA/TTS case study.

## Model Definition
### Model Creation
Next, create an instance of the testing metamodel. To do this, right
click on the folder ``models'' and select ``New'' / ``Other'' /
``Epsilon'' / ``EMF Model'' and set up the parameters as shown in
Figure~\ref{FIG-NEW-MODEL-GENERATION}. Use ``Browse'' to find
``TestingMM'' as the metamodel URI. The model filename can be chosen
to fit the scenario that the users are setting up.

Now users can complete the steps specified in the SESAME
simulation-based testing methodology. When the model is completed, or
when there are any changes to the experiments, right click on the
project, and select ``SESAME'' / ``Generate SESAME Code'' to
regenerate code for metric templates and experiment runners based on
it (Figure \ref{FIG-SESAME-WIZARD}).

\jrhchanged{After this code generation is performed for the first
  time, the project structure must be changed to a Maven
  project. Users should right-click on the project, select
  ``Configure'' / ``Convert to Maven Project''. Then the user should
  right-click and select ``Maven'' / ``Update Project'' to ensure all
  the dependencies are updated.}

### Setting up the Testing Model
### Setting up MRS model

