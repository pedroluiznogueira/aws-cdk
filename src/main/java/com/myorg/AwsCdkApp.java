package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class AwsCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        VpcStack vpcStack = new VpcStack(app, "Vpc");

        // we need to specify wich vpc this cluster is going to be deployed to
        ClusterStack clusterStack = new ClusterStack(app, "Cluster", vpcStack.getVpc());

        // specify the dependencies to avoid confusions
        clusterStack.addDependency(vpcStack);

        app.synth();
    }
}

