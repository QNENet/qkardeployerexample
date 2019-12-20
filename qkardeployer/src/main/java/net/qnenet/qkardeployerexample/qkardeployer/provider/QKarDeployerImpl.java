package net.qnenet.qkardeployerexample.qkardeployer.provider;

import net.qnenet.qkardeployerexample.qkardeployer.api.QKarDeployer;
import org.apache.karaf.kar.KarService;
import org.apache.karaf.kar.internal.Kar;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component(immediate = true)
public class QKarDeployerImpl implements QKarDeployer {
    static Logger log = LoggerFactory.getLogger(QKarDeployerImpl.class);

    @Reference
    KarService karService;

    private Path karFilePath;
    private Path userHomePath;
    private Path qneSystemPath;
    private Path karsPath;

    @Activate
    public void activate() throws Exception {

        String currentPathStr = Paths.get(".").toAbsolutePath().toString();

        String[] parts = null;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            parts = currentPathStr.split("\\\\");
            userHomePath = Paths.get(parts[1], parts[2]);
            qneSystemPath = Paths.get(userHomePath.toString(), parts[3]);
        } else {
            parts = currentPathStr.split("/");
            userHomePath = Paths.get("/", parts[1], parts[2]);
            qneSystemPath = Paths.get(userHomePath.toString(), parts[3]);
        }

        karsPath = Paths.get(qneSystemPath.toString(), "kars");


        karFilePath = Paths.get(karsPath.toString(), "qkartestfeatures-1.0-SNAPSHOT.kar");
        karService.install(karFilePath.toUri());

        log.info("Hello from -> " + getClass().getSimpleName());
    }

    @Deactivate
    public void deactivate() throws Exception {
        karService.uninstall(new Kar(karFilePath.toUri()).getKarName());
        log.info("Goodbye from -> " + getClass().getSimpleName());
    }

}
