package net.qnenet.qkardeployerexample.qkartest.provider;

import net.qnenet.qkardeployerexample.qkartest.api.QKarTest;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class QKarTestImpl implements QKarTest {

    static Logger log = LoggerFactory.getLogger(QKarTestImpl.class);

    @Activate
    public void activate() {
        log.info("Hello from -> " + getClass().getSimpleName());
    }

    @Deactivate
    public void deactivate() {
        log.info("Goodbye from -> " + getClass().getSimpleName());
    }

}
