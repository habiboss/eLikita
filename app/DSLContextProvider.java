

//import com.google.inject.Provider;
//import com.google.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import play.db.Database;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class DSLContextProvider implements Provider<DSLContext> {

    /*
     Avoid caching Connection in ConnectionProvider
     This practice has been seen a couple of times on the internet, in various sample projects, blog posts, etc.
     It is generally not a good idea to cache the Connection in a `ConnectionProvider`, as the `ConnectionProvider`
     should be stateless and threadsafe to be more generally useful, e.g. when injected via DI
    */

    private Database db;

    private DSLContext sqlContext;

    @Inject
    DSLContextProvider(Database db) {
        if (null != db) {
            this.db=db;
            this.sqlContext = DSL.using(db.getConnection(), SQLDialect.POSTGRES_9_5);
        } else {
            System.err.println("*********************CONSTRUCTOR DB connection is NULL!****************************");
        }
    }

    @Override
    public DSLContext get() {

        if (null == this.db) {
            System.err.println("*********************DB connection is NULL!****************************");
        }

        if (null == this.sqlContext) {
            this.sqlContext = DSL.using(this.db.getConnection(), SQLDialect.POSTGRES_9_5);
        }

        return this.sqlContext;
    }

}
