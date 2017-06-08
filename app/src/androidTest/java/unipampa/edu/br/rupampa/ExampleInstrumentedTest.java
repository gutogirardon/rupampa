package unipampa.edu.br.rupampa;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import java.util.List;

import unipampa.edu.br.rupampa.db.DBHelper;

import static org.junit.Assert.assertNotNull;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleInstrumentedTest extends Instrumentation {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        //    Refeicao r = new Refeicao();
        DBHelper db = new DBHelper(InstrumentationRegistry.getTargetContext());
        List list;

        //   r.setPratoPrincipal("Arroz");

        //   r.setId(5858);

        list = db.getRefeicoes();

        // db.addRefeicao(r);
        assertNotNull(list);
        //  assertEquals("Arroz", r.getPratoPrincipal());
    }


}
