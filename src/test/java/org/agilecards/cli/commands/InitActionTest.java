package org.agilecards.cli.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 * CLI Init Command
 * Created by Beewy on 25/02/2017.
 */
public class InitActionTest extends BaseActionTest {

    @Test
    public void testInitAction() throws Exception {
        parser.parseArgument("init");
        Assert.assertTrue(cliConfiguration.getAction() instanceof InitCommand);
        Assert.assertFalse(cliConfiguration.isVerbose());
    }

    @Test
    public void testInitActionWithVerbose() throws Exception {
        parser.parseArgument("--log","init");
        Assert.assertTrue(cliConfiguration.getAction() instanceof InitCommand);
        Assert.assertTrue(cliConfiguration.isVerbose());
    }

    @Test
    public void showSpecificUsage() throws Exception {
        parser.parseArgument("init","--help");
        Assert.assertTrue(cliConfiguration.getAction().isHelp());

        String expectedSpecificUsage =
                "agile-cards init : Init the configuration and template files" + System.getProperty("line.separator") +
                        System.getProperty("line.separator") +
                        "Usage : agile-cards init [options]" + System.getProperty("line.separator") +
                        " --help (-H) : Show specific usage (default: false)" + System.getProperty("line.separator");

        cliConfiguration.getAction().showSpecificUsage();
        Assert.assertEquals(expectedSpecificUsage,outContent.toString());
    }

}