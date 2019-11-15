package entity;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @ClassName MySqlJDBC
 * @Description TODO
 * @Author pay
 * @DATE 2019/11/15 10:02
 **/
public class MySqlJDBC {
    private Logger logger = Logger.getLogger (getClass ().getName ());
    private String user;
    private String password;
    private String dataBaseName;
    private String connetUrl = "jdbc:mysql://localhost:3306/dataBaseName?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=Asia/Shanghai";
    private Connection connection;
    private Statement statement;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace ();
        }
    }
    public MySqlJDBC(String user, String password, String dataBaseName) {
        this.user = user;
        this.password = password;
        this.dataBaseName = dataBaseName;
    }
    public MySqlJDBC connection(){
        try {
            connetUrl = connetUrl.replaceAll ("dataBaseName",dataBaseName);
            connection = DriverManager.getConnection (connetUrl,user,password);
        }catch (SQLException e){
            logger.log (Level.WARNING,e.getMessage (),e);
        }
        return this;
    }
    public MySqlJDBC queryTables(QueryCallback QueryCallback){
        query ("SHOW tables ",QueryCallback);
        return this;
    }
    public MySqlJDBC queryTabColumns(String tableName,QueryCallback QueryCallback){
        query ("DESC "+tableName,QueryCallback);
        return this;
    }
    public void query(String sql,QueryCallback QueryCallback){
        ResultSet resultSet = null;
        try {
            if(connection==null||connection.isClosed ()){
                connection ();
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery (sql);
            if(QueryCallback!=null){
                QueryCallback.getQuery (resultSet);
            }
        }catch (SQLException e){
            logger.log (Level.WARNING,e.getMessage (),e);
        }finally {
            close (resultSet);
            close ();
        }
    }
    private void close(){
        try {
            if(statement!=null){
                statement.close ();
            }
            if(connection!=null){
                connection.close ();
            }
        }catch (SQLException e){
            logger.log (Level.WARNING,e.getMessage (),e);
        }
    }
    private void close(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close ();
            }catch (SQLException e){
                logger.log (Level.WARNING,e.getMessage (),e);
            }
        }
    }
    public interface QueryCallback{
        void getQuery(ResultSet resultSet) throws SQLException;
    }
}
