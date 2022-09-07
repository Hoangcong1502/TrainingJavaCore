package edu.hanoi.jazz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {
    private final static Logger LOGGER = Logger.getLogger(ContextStartEventHandler.class);
    @Autowired
    private DataSource dataSource;
    DatabaseMetaData databaseMetaData;
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("b1");
        try{
            createTable("congnh_group","create table congnh_group (\n" +
                    "    id number(4) primary key,\n" +
                    "    name varchar2(100)\n" +
                    ")");
        }catch (Exception e){
            LOGGER.error(e,e);
            e.printStackTrace();
        }
        LOGGER.info("-- Context start application "+dataSource);
    }

    private void createTable(String name, String script) throws SQLException {
        databaseMetaData = dataSource.getConnection().getMetaData();
        ResultSet rs = databaseMetaData.getTables(null,null,name,null);
        if(rs.next()){
            LOGGER.info("congnh_student "+rs.getString("name")+" already exists!");
            return;
        }
        dataSource.getConnection().createStatement().executeUpdate(script);
    }
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


}
