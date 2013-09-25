package com.everis.bbd.snconnector;

import java.util.logging.Logger;

import com.everis.bbd.snconnector.linkedin.LinkedInConnector;
import com.everis.bbd.snconnector.twitter.TwitterConnector;
import com.everis.bbd.snconnector.twitter.TwitterStreamConnector;

/**
 * Factory for social network connectors.
 */
public class SNConnectorFactory 
{
	/**
	 * Logger.
	 */
	private static Logger log = Logger.getLogger(SNConnectorFactory.class.getName());

	/**
	 * Identifier for TwitterConnector.
	 */
	public static final int TWITTER_CONNECTOR = 1;
	
	/**
	 * Identifier for TwitterConnector.
	 */
	public static final int TWITTER_STREAM_CONNECTOR = 2;
	
	/**
	 * Identifier for FacebookConnector.
	 */
	private static final int FACEBOOK_CONNECTOR = 3;
	
	/**
	 * Identifier for LinkedinConnector.
	 */
	private static final int LINKEDIN_CONNECTOR = 4;
	

	/**
	 * SNConnectorFactory can't be instantiated.
	 */
	private SNConnectorFactory() {}
	
	/**
	 * Given a string with the name of a social network it returns the id.
	 * 
	 * @param name of the social network.
	 * @return the identifier.
	 */
	public static int getConnectorId(String name)
	{
		if (name.equals("Twitter") || name.equals("twitter"))
		{
			return SNConnectorFactory.TWITTER_CONNECTOR;
		}
		else if (name.equals("TwitterStream") || name.equals("twitterstream") 
				|| name.equals("twitterstreaming") || name.equals("TwitterStreaming"))
		{
			return SNConnectorFactory.TWITTER_STREAM_CONNECTOR;
		}
		else if (name.equals("Facebook") || name.equals("facebook"))
		{
			return SNConnectorFactory.FACEBOOK_CONNECTOR;
		}
		else if (name.equals("Linkedin") || name.equals("LinkedIn") || name.equals("linkedin"))
		{
			return SNConnectorFactory.LINKEDIN_CONNECTOR;
		}
		return 0;
	}
	
	/**
	 * Returns the connector for the social network type.
	 * 
	 * @param type social network.
	 * @return connector (SNConnector).
	 */
	public static SNConnector getConnector(int type)
	{
		SNConnector connector = null;
		switch (type) 
		{
		case TWITTER_CONNECTOR:
			connector = new TwitterConnector();
			break;
		case TWITTER_STREAM_CONNECTOR:
			connector = new TwitterStreamConnector();
			break;
		case LINKEDIN_CONNECTOR:
			connector = new LinkedInConnector();
			break;
		default:
			log.warning("Connector type does not exist");
			break;
		}
		return connector;
	}
	
	/**
	 * Returns the connector for the social network type.
	 * 
	 * @param type social network.
	 * @param propertiesFile connector properties file.
	 * @return connector (SNConnector).
	 */
	public static SNConnector getConnector(int type, String propertiesFile)
	{
		SNConnector connector = null;
		switch (type) 
		{
		case TWITTER_CONNECTOR:
			connector = new TwitterConnector(propertiesFile);
			break;
		case TWITTER_STREAM_CONNECTOR:
			connector = new TwitterStreamConnector(propertiesFile);
			break;
		case LINKEDIN_CONNECTOR:
			connector = new LinkedInConnector(propertiesFile);
			break;
		default:
			log.warning("Connector type does not exist");
			break;
		}
		return connector;
	}
}
