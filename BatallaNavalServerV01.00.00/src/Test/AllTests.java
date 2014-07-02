package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DecodificacionTest.class,
               MensajeColocarTest.class,
               MensajeConectarTest.class,
               MensajeDisparoTest.class,
               PruebaDeDatos.class})
public class AllTests {
}
