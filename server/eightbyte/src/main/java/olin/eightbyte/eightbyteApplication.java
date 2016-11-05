package olin.eightbyte;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class eightbyteApplication extends Application<eightbyteConfiguration> {

    public static void main(final String[] args) throws Exception {
        new eightbyteApplication().run(args);
    }

    @Override
    public String getName() {
        return "eightbyte";
    }

    @Override
    public void initialize(final Bootstrap<eightbyteConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final eightbyteConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
