package olin.eightbyte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.skife.jdbi.v2.DBI;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import olin.eightbyte.db.SoundByteDAO;
import olin.eightbyte.resources.SoundByteResource;

public class EightbyteApplication extends Application<EightbyteConfiguration> {

	private String[] words;
	
	
	public static void main(final String[] args) throws Exception {
		new EightbyteApplication().run(args);
	}

	@Override
	public String getName() {
		return "eightbyte";
	}

	@Override
	public void initialize(final Bootstrap<EightbyteConfiguration> bootstrap) {
		try {
			words = loadWords(1000);
		} catch (IOException e) {
			final String[] sa = {"floccinaucinihilipilification"};
			words = sa;
		}
		
		bootstrap.addBundle(new AssetsBundle("/sound/", "/raw/"));
	}

	@Override
	public void run(final EightbyteConfiguration configuration, final Environment environment) {
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
		final SoundByteDAO soundByteDAO = jdbi.onDemand(SoundByteDAO.class);
		
		environment.jersey().register(new SoundByteResource(soundByteDAO));
	}
	
	
	
	private final String getUniqueURI() {
		String uri;
		do {
			uri = "";
			for (int i = 0; i < 3; i ++)
				uri += words[(int) (Math.random()*words.length)];
		} while (false);	//TODO: make sure this URI doesn't actually exist
		return uri;
	}
	
	
	private static final String[] loadWords(int n) throws IOException {
		final BufferedReader in = new BufferedReader(
				new FileReader("src/main/resources/english.txt"));
		String[] output = new String[n];
		for (int i = 0; i < n; i ++)
			output[i] = in.readLine();
		return output;
	}

}
