//package uk.ac.york.sesame.testing.evolutionary.utilities;
//

//import org.eclipse.emf.codegen.ecore.genmodel.presentation.GenModelActionBarContributor.GenerateAction
//
//class TestGenModel {
//	private void createGenModel(final EPackage rootPackage, final String ecoreLocation, final String genModelLocation) {
//
//        GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
//        genModel.setComplianceLevel(GenJDKLevel.JDK70_LITERAL);
//        genModel.setModelDirectory(Constants.GEN_MODEL_MODEL_DIR.getValue());
//        genModel.getForeignModel().add(new Path(ecoreLocation).lastSegment());
//        genModel.setModelName(Constants.GEN_MODEL_MODEL_NAME.getValue());
//        genModel.setRootExtendsInterface(Constants.GEN_MODEL_EXTENDS_INTERFACE.getValue());
//        genModel.initialize(Collections.singleton(rootPackage));
//
//        GenPackage genPackage = (GenPackage)genModel.getGenPackages().get(0);
//        genPackage.setPrefix(Constants.GEN_MODEL_PACKAGE_PREFIX.getValue());
//
//        try {
//            URI genModelURI = URI.createFileURI(genModelLocation);
//            final XMIResourceImpl genModelResource = new XMIResourceImpl(genModelURI);
//            genModelResource.getDefaultSaveOptions().put(XMLResource.OPTION_ENCODING,
//                Constants.GEN_MODEL_XML_ENCODING.getValue());
//            genModelResource.getContents().add(genModel);
//            genModelResource.save(Collections.EMPTY_MAP);
//        } catch (IOException e) {
//            String msg = null;
//            final String genModelLocationCleaned = LogUtil.stripForgeChars(genModelLocation);
//            if (e instanceof FileNotFoundException) {
//                msg = "Unable to open output file " + genModelLocationCleaned;
//            } else {
//                msg = "Unexpected IO Exception writing " + genModelLocationCleaned;
//            }
//            LOGGER.error(msg, e);
//            throw new RuntimeException(msg, e);
//        }
//    }
//}