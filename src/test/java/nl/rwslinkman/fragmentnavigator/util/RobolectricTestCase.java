package nl.rwslinkman.fragmentnavigator.util;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import nl.rwslinkman.fragmentnavigator.BuildConfig;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 26)
abstract public class RobolectricTestCase {}
