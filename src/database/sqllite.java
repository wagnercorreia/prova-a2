package database;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sqllite {
 
    private final String db;
    private SQLiteConnection conn;
    private SQLiteStatement stmm;
    
    public sqllite(String db) {
        this.db = db;
        this.conn = null;
        this.abrirConexao();
    }
    
    private void abrirConexao() {
        this.conn = new SQLiteConnection(new File(this.db));
        try {
            this.conn.open(true);
        } catch (SQLiteException ex) {
            Logger.getLogger(sqllite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fecharConexao() {
        this.stmm.dispose();
        this.conn.dispose();
    }
    
    public SQLiteStatement executarQuerry(String sql) {
        try {
            this.stmm = this.conn.prepare(sql);
            return this.stmm;
        } catch (SQLiteException ex) {
            Logger.getLogger(sqllite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}