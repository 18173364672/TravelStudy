package com.accp.qyj.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.OrderMapper;
import com.accp.dao.OrderdetailMapper;
import com.accp.dao.ProjectMapper;
import com.accp.domain.Order;
import com.accp.domain.Orderdetail;
import com.accp.domain.OrderdetailExample;
import com.accp.domain.Project;
import com.accp.qyj.service.OrderdetailService;
import com.alibaba.fastjson.JSON;

@Service
@Transactional
public class OrderdetailServiceImpl implements OrderdetailService {

	@Autowired
	OrderdetailMapper m;

	@Autowired
	ProjectMapper pm;
	
	@Autowired
	OrderMapper om;

	@Override
	public int countByExample(OrderdetailExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(OrderdetailExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Orderdetail record) {
		// TODO Auto-generated method stub
		return m.insert(record);
	}

	@Override
	public int insertSelective(Orderdetail record) {
		// TODO Auto-generated method stub
		return m.insertSelective(record);
	}

	@Override
	public List<Orderdetail> selectByExample(OrderdetailExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orderdetail selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Orderdetail record, OrderdetailExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Orderdetail record, OrderdetailExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Orderdetail record) {
		// TODO Auto-generated method stub
		return m.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Orderdetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Orderdetail queryTime(Integer oid) {
		// TODO Auto-generated method stub
		List<Orderdetail> od = m.queryByOid(oid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MILLISECOND, 0);

		Date time = null;
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 12);
		c1.set(Calendar.MINUTE, 30);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);
		Date time1 = c1.getTime();

		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 18);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);
		Date time2 = c2.getTime();

		for (Orderdetail orderdetail : od) {
			if (orderdetail.getStarttime() == null && time == null) {
				c.add(Calendar.DAY_OF_MONTH, 1);
				c.set(Calendar.HOUR_OF_DAY, 8);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				orderdetail.setStarttime(c.getTime());
				c.add(Calendar.HOUR_OF_DAY, 2);
				orderdetail.setEndtime(c.getTime());
				time = c.getTime();
				queryByFid(orderdetail);
			} else if (time != null && time.getTime() != time1.getTime() && time.getTime() != time2.getTime()) {
				c.add(Calendar.MINUTE, 30);
				c.set(Calendar.SECOND, 0);
				orderdetail.setStarttime(c.getTime());
				c.add(Calendar.HOUR_OF_DAY, 2);
				orderdetail.setEndtime(c.getTime());
				time = c.getTime();
				queryByFid(orderdetail);
			} else if (time.getTime() == time1.getTime()) {
				c.add(Calendar.MINUTE, 30);
				c.set(Calendar.SECOND, 0);
				c1.add(Calendar.DAY_OF_MONTH, 1);
				time1 = c1.getTime();
				c.add(Calendar.MINUTE, 30);
				orderdetail.setStarttime(c.getTime());
				c.add(Calendar.HOUR_OF_DAY, 2);
				orderdetail.setEndtime(c.getTime());
				time = c.getTime();
				queryByFid(orderdetail);
			} else if (time.getTime() == time2.getTime()) {
				c2.add(Calendar.DAY_OF_MONTH, 1);
				c.add(Calendar.DAY_OF_MONTH, 1);
				c.set(Calendar.HOUR_OF_DAY, 8);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				orderdetail.setStarttime(c.getTime());
				c.add(Calendar.HOUR_OF_DAY, 2);
				orderdetail.setEndtime(c.getTime());
				time = c.getTime();
				time2 = c2.getTime();
				//获取当前项目中的场地列表中的最小时间对于的场地
				queryByFid(orderdetail);
				
			}
		}

		return null;
	}
	
	@Override
	public Orderdetail queryByFid(Orderdetail od) {
		
		//根据订单中的项目编号，获取项目对应的所有场地，
		//然后根据场地获取最小时间对应的场地。如果有空直接返回对应场地
		
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Project p = pm.queryd(od.getPid());
		String ids1 = p.getIds1();
		String[] fid = ids1.split(",");
		String ids = p.getIds();
		String[] jid = ids.split(",");
		
		int j = 0;
		for (int i = 0; i < fid.length; i++) {
			od.setFid(Integer.valueOf(fid[i]));
			od.setSpare1(jid[i]);
			Date strattime = od.getStarttime();
			Date endtime = od.getEndtime();
			String strattime1 = sdf.format(strattime);
			String endtime1 = sdf.format(endtime);
			try {
				od.setStarttime1(sdf.parse(strattime1));
				od.setEndtime1(sdf.parse(endtime1));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Orderdetail od1 = m.queryByFid(od);
			if (od1 == null) {
				j = updateByPrimaryKeySelective(od);
				break;
			}
		}

		if (j == 0) {
			for (int i = 0; i < fid.length; i++) {
				Orderdetail od3 = m.queryEndtime(Integer.valueOf(fid[i]));
				od3.setOid(od.getOid());
				od3.setId(od.getId());
				queryTime1(od3);
				break;
			}
		}

		return null;
	}

	@Override
	public Orderdetail queryTime1(Orderdetail od) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(od.getEndtime().getTime());
		c.set(Calendar.SECOND, 0);

		Date time = c.getTime();
//		System.out.println("获取到的最后一个时间：" + sdf.format(time));

		Calendar c1 = Calendar.getInstance();
		c1.setTimeInMillis(od.getEndtime().getTime());
		if (c1.get(Calendar.HOUR_OF_DAY) > 12) {
			c1.add(Calendar.DAY_OF_MONTH, 1);
		}
		c1.set(Calendar.HOUR_OF_DAY, 12);
		c1.set(Calendar.MINUTE, 30);
		c1.set(Calendar.SECOND, 0);
		Date time1 = c1.getTime();
//		System.out.println("第二天中午" + sdf.format(time1));

		Calendar c2 = Calendar.getInstance();
		c2.setTimeInMillis(od.getEndtime().getTime());
		if (c1.get(Calendar.HOUR_OF_DAY) == 18) {
			c1.add(Calendar.DAY_OF_MONTH, 1);
		}
		c2.set(Calendar.HOUR_OF_DAY, 18);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		Date time2 = c2.getTime();
//		System.out.println("第二天下午" + sdf.format(time2));

		if (time != null && time.getTime() != time1.getTime() && time.getTime() != time2.getTime()) {
			c.add(Calendar.MINUTE, 30);
			c.set(Calendar.SECOND, 0);
			od.setStarttime(c.getTime());
			System.out.println("开始时间1：" + sdf.format(c.getTime()));
			c.add(Calendar.HOUR_OF_DAY, 2);
			od.setEndtime(c.getTime());
			System.out.println("结束时间1：" + sdf.format(c.getTime()));
			time = c.getTime();
			queryByFid1(od);
		} else if (time.getTime() == time1.getTime()) {
			c.add(Calendar.MINUTE, 30);
			c.set(Calendar.SECOND, 0);
			c1.add(Calendar.DAY_OF_MONTH, 1);
			time1 = c1.getTime();
			c.add(Calendar.MINUTE, 30);
			od.setStarttime(c.getTime());
			System.out.println("开始时间2：" + sdf.format(c.getTime()));
			c.add(Calendar.HOUR_OF_DAY, 2);
			od.setEndtime(c.getTime());
			System.out.println("结束时间2：" + sdf.format(c.getTime()));
			time = c.getTime();
			queryByFid1(od);
		} else if (time.getTime() == time2.getTime()) {
			c2.add(Calendar.DAY_OF_MONTH, 1);
			c.add(Calendar.DAY_OF_MONTH, 1);
			c.set(Calendar.HOUR_OF_DAY, 8);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			od.setStarttime(c.getTime());
			System.out.println("开始时间3：" + sdf.format(c.getTime()));
			c.add(Calendar.HOUR_OF_DAY, 2);
			od.setEndtime(c.getTime());
			System.out.println("结束时间3：" + sdf.format(c.getTime()));
			time = c.getTime();
			time2 = c2.getTime();
			queryByFid1(od);
		}

		return null;
	}

	@Override
	public List<Orderdetail> queryByOid(Integer oid) {
		// TODO Auto-generated method stub
		return m.queryByOid(oid);
	}

	@Override
	public Orderdetail queryByFid1(Orderdetail od) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date strattime = od.getStarttime();
		Date endtime = od.getEndtime();
		String strattime1 = sdf.format(strattime);
		String endtime1 = sdf.format(endtime);
		try {
			od.setStarttime1(sdf.parse(strattime1));
			od.setEndtime1(sdf.parse(endtime1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Orderdetail od1 = m.queryByFid(od);
		if (od1 == null) {
			updateByPrimaryKeySelective(od);
		}
		return null;
	}

	@Override
	public Integer[] qeuryid(Order o) {
		// TODO Auto-generated method stub
		
		om.updateByPrimaryKeySelective(o);
		return null;
	}

}
