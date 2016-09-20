/**
 * 
 */
package com.madmatsoft.store3d.controlers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Controller
public class LearningApiController {
	
	@RequestMapping("/dataSourceInfo")
	public String dataSourceInfo(Model model){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/appServlet/servlet-context.xml");
		
		BasicDataSource myDataSource = (BasicDataSource)applicationContext.getBean("myDataSource");
		
		Map<String,String> infos = new HashMap<String,String>();
		
		infos.put("Pool size", String.valueOf(myDataSource.getInitialSize()));
		
		infos.put("Default catalog", myDataSource.getDefaultCatalog());
		
		infos.put("Is AutoCommitEnabled?", String.valueOf(myDataSource.getDefaultAutoCommit()));
		
		infos.put("JDBC driver class name", myDataSource.getDriverClassName());
		
		infos.put("URL", myDataSource.getUrl());
		
		infos.put("User name", myDataSource.getUsername());
		
		infos.put("Password", myDataSource.getPassword());
		
		infos.put("Connection validation query before returning them", myDataSource.getValidationQuery());
		
		infos.put("Default read only?", String.valueOf(myDataSource.getDefaultReadOnly()));
		try {
			infos.put("Login timeout", String.valueOf(myDataSource.getLoginTimeout()) + "s");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		infos.put("Maximum activ connection in the same time", String.valueOf(myDataSource.getMaxActive()));
		
		infos.put("Maximum idle connections", String.valueOf(myDataSource.getMaxIdle()));
		
		infos.put("Minimum idle connections", String.valueOf(myDataSource.getMinIdle()));
		
		infos.put("Maximum open prepared statements", String.valueOf(myDataSource.getMaxOpenPreparedStatements()));
		
		infos.put("Maximum wait for connection from pool", String.valueOf(myDataSource.getMaxWait()) + "ms");
		
		infos.put("Current number of active connections", String.valueOf(myDataSource.getNumActive()));
		
		infos.put("Current idle connections", String.valueOf(myDataSource.getNumIdle()));
		
		infos.put("Timeout for connection validation query", String.valueOf(myDataSource.getValidationQueryTimeout()));

		model.addAttribute("infos", infos);
		return "learningInfos";
	}
}
