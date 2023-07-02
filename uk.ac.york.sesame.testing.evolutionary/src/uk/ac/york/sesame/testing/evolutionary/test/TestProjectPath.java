//package uk.ac.york.sesame.testing.evolutionary.test;
//
//import org.eclipse.core.resources.*;
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.core.runtime.IPath;
//
//public class TestProjectPath {
//	public static void main(String [] args) {
//		IWorkspace workspace = ResourcesPlugin.getWorkspace();
//		IWorkspaceRoot workspaceRoot = workspace.getRoot();
//		
//		IProject dslProject = workspaceRoot.getProject("uk.ac.york.sesame.testing.dsl");
//		if (dslProject.exists() && !dslProject.isOpen()) {
//			try {
//				dslProject.open(null);
//				IPath dslPath = dslProject.getFullPath();
//				String pathString = dslPath.toString();
//				System.out.println("dsl path = " + pathString);
//			} catch (CoreException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//		
//		
//	}
//}
