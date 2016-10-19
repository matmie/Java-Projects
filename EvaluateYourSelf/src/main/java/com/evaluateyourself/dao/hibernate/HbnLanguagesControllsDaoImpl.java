package com.evaluateyourself.dao.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.evaluateyourself.dao.LanguagesControllsDao;
import com.evaluateyourself.model.LanguagesControlls;
import com.evaluateyourself.utils.stuctures.LanguagesControllsSpecificInfo;

@Repository
public class HbnLanguagesControllsDaoImpl extends AbstractHbnDao<LanguagesControlls> implements LanguagesControllsDao {

	@Override
	public Map<String, LanguagesControllsSpecificInfo> getControllsByParentIdAndLanguage(String parentId, String language) {
		String languageColumn = "lc" + language;
		Query query = super.getCurrentSession().createQuery("select lcname, " + languageColumn + ", lchaschild from LanguagesControlls where lcfatherid =:lcparentid");
		query.setParameter("lcparentid", parentId);
		Map<String, LanguagesControllsSpecificInfo> result = new HashMap<String, LanguagesControllsSpecificInfo>();
		List<Object[]> resultList = (List<Object[]>)query.list();
		
		for(Object[] res: resultList){
			result.put((String)res[0], new LanguagesControllsSpecificInfo((String)res[1], (Boolean)res[2]));
		}
		return result;
	}
}

