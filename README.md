# qkardeployerexample

Project to help workout how to get KarService#install working in my code.

I am trying to use a feature to in effect turn other features on and off.

In the qkardeployer activator I am trying to install (turn on) the qkartest feature.

I do not seem to be setting the necessary features/bundles in the qkardeployerfeatures feature.xml

My full project feature.xml

<?xml version="1.0" encoding="UTF-8"?>

<features name="qnewsystemfeatures-${project.version}" xmlns="http://karaf.apache.org/xmlns/features/v1.6.0">


    <feature name='qsystemmanager' description='QSystemManager Features' version='${project.version}'>
        <details>QSystemManager Features</details>

        <bundle>mvn:org.apache.karaf.deployer/org.apache.karaf.deployer.kar/${karaf.version}</bundle>

        <bundle>mvn:net.qnenet.qsystemmanager/qsystemrunner/${qne.version}</bundle>
    </feature>

</features>

produces this

org.apache.felix.resolver.reason.ReasonException: Unable to resolve root: 
missing requirement [root] osgi.identity; osgi.identity=qsystemmanager; 
type=karaf.feature; version="[1.0.0.SNAPSHOT,1.0.0.SNAPSHOT]"; 
filter:="(&(osgi.identity=qsystemmanager)(type=karaf.feature)(version>=1.0.0.SNAPSHOT)(version<=1.0.0.SNAPSHOT))" 
[caused by: Unable to resolve qsystemmanager/1.0.0.SNAPSHOT: missing requirement [qsystemmanager/1.0.0.SNAPSHOT] 
osgi.identity; osgi.identity=qsystemrunner; type=osgi.bundle; version="[1.0.0.SNAPSHOT,1.0.0.SNAPSHOT]"; 
resolution:=mandatory [caused by: Unable to resolve qsystemrunner/1.0.0.SNAPSHOT: missing requirement [qsystemrunner/1.0.0.SNAPSHOT] 
osgi.wiring.package; filter:="(osgi.wiring.package=org.apache.karaf.deployer.kar)"]]

