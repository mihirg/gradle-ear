package in.gore;

/**
 * http://www.nailedtothex.org/roller/kyle/entry/arquillian-ejb-jar-ear-testing
 * https://developer.jboss.org/thread/195455
 */

import in.gore.ISimpleSession;
import in.gore.SimpleSessionBean;
import in.gore.entities.User;
import javax.ejb.EJB;
import java.io.File;
import java.util.zip.ZipFile;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.gradle.archive.importer.embedded.EmbeddedGradleImporter;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SimpleSessionBeanTest {

    @EJB
    ISimpleSession bean;

//    @Deployment
//    public static JavaArchive newTestDeploy() throws Exception {
//        return ShrinkWrap.create(EmbeddedGradleImporter.class).forThisProjectDirectory().importBuildOutput()
//                .as(JavaArchive.class);
//    }

    @Deployment
    public static JavaArchive createDeployment() throws Exception {
        return ShrinkWrap.create(ZipImporter.class).importZip(new ZipFile("build/libs/testbeans.jar")).as(JavaArchive.class);
    }


//    @Deployment
//    public static EnterpriseArchive createDeployment() throws Exception {
//        final JavaArchive ejbJar = ShrinkWrap.createFromZipFile(JavaArchive.class, new File("build/libs/testbeans.jar"));
//
//        final WebArchive webWar = ShrinkWrap.create(WebArchive.class, "test.war")
//                .addAsWebInfResource(new File("src/test/resources/glassfish-config/glassfish-web.xml"));
//        final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class)
//                .setApplicationXML(new File("src/test/resources/glassfish-config/application.xml"))
//                .addAsModule(ejbJar)
//                .addAsModule(webWar);
//        return ear;
//    }

//    @Deployment
//    public static JavaArchive createDeployment() throws Exception {
//        JavaArchive archive = ShrinkWrap.create(JavaArchive.class).addClass(ISimpleSession.class);
//        archive.addClass(SimpleSessionBean.class);
////        archive.addClass(User.class);
//        return archive;
//    }

    @Test
    public void shouldCreateGreeting() {
//        this.bean.createUser();
//        Assert.assertNotNull(this.bean.getUser());
        Assert.assertNotNull(bean);
    }
}
