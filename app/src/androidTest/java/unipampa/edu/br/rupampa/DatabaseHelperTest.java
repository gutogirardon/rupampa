package unipampa.edu.br.rupampa;

import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import unipampa.edu.br.rupampa.db.DBHelper;
import unipampa.edu.br.rupampa.model.Refeicao;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest {

    private DBHelper database;

    @Before
    public void setUp() throws Exception {
        getTargetContext().deleteDatabase(DBHelper.DATABASE_NOME);
        database = new DBHelper(InstrumentationRegistry.getTargetContext());
    }

    @After
    public void tearDown() throws Exception {
   //     database.close();
    }

    @Test
    public void testListaVazia() throws Exception{

        DBHelper db = new DBHelper(InstrumentationRegistry.getTargetContext());
        List list;

        list = db.getRefeicoes();
        assertNotNull(list);
    }


//Opção Vegetariana
    @Test
    public void testVeganCorreto() throws Exception {
        Refeicao r = new Refeicao();
        r.setOpcaoVegetariana("Proteína de Soja com Legumes");

        r.setId(5858);
        database.addRefeicao(r);
        assertEquals("Proteína de Soja com Legumes", r.getOpcaoVegetariana());

    }

    @Test
    public void testVeganIncorreto() throws Exception {
        Refeicao r = new Refeicao();
        r.setOpcaoVegetariana("Proteína de Soja com Legumes");

        r.setId(5858);
        database.addRefeicao(r);
        assertNotEquals("Proteínas", r.getOpcaoVegetariana());

    }

    //Guarnicação
    @Test
    public void testGuarnicaoCorreta() throws Exception {
        Refeicao r = new Refeicao();
        r.setGuarnicao("Polenta cremosa");

        r.setId(5858);
        database.addRefeicao(r);
        assertEquals("Polenta cremosa", r.getGuarnicao());

    }

    @Test
    public void testGuarnicaoIncorreta() throws Exception {
        Refeicao r = new Refeicao();
        r.setGuarnicao("Polenta cremosa");

        r.setId(5858);
        database.addRefeicao(r);
        assertNotEquals("Massa", r.getGuarnicao());

    }
    //Acompanhamento
    @Test
    public void testAcompanhamentoCorreto() throws Exception {
        Refeicao r = new Refeicao();
        r.setAcompanhamento("Arroz integral");

        r.setId(5858);
        database.addRefeicao(r);
        assertEquals("Arroz integral", r.getAcompanhamento());

    }

    @Test
    public void testAcompanhamentoIncorreto() throws Exception {
        Refeicao r = new Refeicao();
        r.setAcompanhamento("Arroz integral");

        r.setId(5858);
        database.addRefeicao(r);
        assertNotEquals("Feijão", r.getAcompanhamento());

    }

    //Sobremesa
    @Test
    public void testSobremesaCorreta() throws Exception {
        Refeicao r = new Refeicao();
        r.setSobremesa("Gelatina");

        r.setId(5858);
        database.addRefeicao(r);
        assertEquals("Gelatina", r.getSobremesa());

    }


    @Test
    public void testSobremesaIncorreta() throws Exception {
        Refeicao r = new Refeicao();
        r.setSobremesa("Gelatina");

        r.setId(5858);
        database.addRefeicao(r);
        assertNotEquals("Mousse", r.getSobremesa());

    }

    //Sobremesa
    @Test
    public void testSucoCorreto() throws Exception {
        Refeicao r = new Refeicao();
        r.setSuco("Laranja");

        r.setId(5858);
        database.addRefeicao(r);
        assertEquals("Laranja", r.getSuco());

    }


    @Test
    public void testSucoIncorreto() throws Exception {
        Refeicao r = new Refeicao();
        r.setSuco("Laranja");

        r.setId(5858);
        database.addRefeicao(r);
        assertNotEquals("Uva", r.getSuco());

    }

    @Test
    public void testPratoPrincipalCorreto() throws Exception {
        Refeicao r = new Refeicao();
        r.setPratoPrincipal("Carne com batata/ Frango com molho");

        r.setId(5858);
        database.addRefeicao(r);
        assertEquals("Carne com batata/ Frango com molho", r.getPratoPrincipal());

    }

    @Test
    public void testPratoPrincipalIncorreto() throws Exception {
        Refeicao r = new Refeicao();
        r.setPratoPrincipal("Carne com batata/ Frango com molho");

        r.setId(5858);
        database.addRefeicao(r);
        assertNotEquals("Linguiça Toscana", r.getPratoPrincipal());

    }

    @Test
    public void testDeletar() throws Throwable {
        InstrumentationRegistry.getTargetContext().deleteDatabase(DBHelper.DATABASE_NOME);
        SQLiteDatabase db = new DBHelper(InstrumentationRegistry.getTargetContext()).getWritableDatabase();
        assertEquals(true, db.isOpen());
        db.close();
    }
}