package unipampa.edu.br.rupampa;

import android.app.Instrumentation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.runner.AndroidJUnit4;
import android.test.ServiceTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;

import unipampa.edu.br.rupampa.db.DBHelper;
import unipampa.edu.br.rupampa.model.Refeicao;

import static junit.framework.Assert.assertEquals;

/**
 * Created by 131150028 on 08/11/2016.
 */

@RunWith(AndroidJUnit4.class)

public class TesteDB extends Instrumentation {

    private Context getTestContext()
    {
        try
        {
            Method getTestContext = ServiceTestCase.class.getMethod("getTestContext");
            return (Context) getTestContext.invoke(this);
        }
        catch (final Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }
    @Test
    public void testDeletarl() throws Throwable{
        getTestContext().deleteDatabase("rupampa.db");
        SQLiteDatabase db = new DBHelper(this.getTestContext()).getWritableDatabase();
        assertEquals(true, db.isOpen());
        db.close();
  //      DBHelper db = new DBHelper(null, null, null, 1);
    //    db.deleteRefeicao(2);


    }
    @Test
    public void testPratoPrincipal() throws Throwable {
 Refeicao r = new Refeicao();
        DBHelper db = new DBHelper(getTestContext());
        SQLiteDatabase d = db.getWritableDatabase();

     //   List list;

        r.setPratoPrincipal("Carne com batata/ Frango com molho");

        r.setId(5858);

     //   list = db.getRefeicoes();

        db.addRefeicao(r);
     //   assertNotNull(list);
        assertEquals("Carne com batata/ Frango com molho", r.getPratoPrincipal());


    }


}
