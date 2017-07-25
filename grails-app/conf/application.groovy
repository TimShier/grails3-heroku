environments {

  development{
    dataSource {
      pooled = "true"
    jmxExport = "true"
    driverClassName = org.h2.Driver
    username = "sa"
    password = ""

    dbCreate: "create-drop"
    url: "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
    }
  }

  production {
    dataSource {
      dbCreate = "update"
      driverClassName = "org.postgresql.Driver"
      dialect = org.hibernate.dialect.PostgreSQLDialect
      uri = new URI(System.env.DATABASE_URL?:"postgres://test:test@localhost/test")
      url = "jdbc:postgresql://" + uri.host + ":" + uri.port + uri.path
      username = uri.userInfo.split(":")[0]
      password = uri.userInfo.split(":")[1]
    }
  }

}
