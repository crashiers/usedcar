package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.Set;

import com.cn.jhsoft.usedcar.common.utils.ExcelPOIUtils;
import com.cn.jhsoft.usedcar.modules.api.annotation.AuthIgnore;
import com.cn.jhsoft.usedcar.modules.pm.entity.ApproveWeightMatrixEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.BasicDataEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.DealerEntity;
import com.cn.jhsoft.usedcar.modules.pm.entity.DraEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.BasicDataService;
import com.cn.jhsoft.usedcar.modules.pm.service.DealerService;
import com.cn.jhsoft.usedcar.modules.pm.service.DraService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.jhsoft.usedcar.modules.pm.entity.DrEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DrService;
import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.IPUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * 置换零售业务
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:56
 */
@RestController
@RequestMapping("/pm/dr")
public class DrController extends AbstractController {
	@Autowired
	private DrService drService;
	@Autowired
	private BasicDataService basicDataService;
	@Autowired
	private DraService draService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:dr:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		if (params.get("sidx") == null || params.get("sidx").toString().equals("")){
			params.put("sidx", "year_month");
			params.put("order", "asc");
		}
		//查询列表数据
        Query query = new Query(params);

		List<DrEntity> drList = drService.queryList(query);
		int total = drService.queryTotal(query);


		DrEntity entityAll = new DrEntity();
		DrEntity entityAvg = new DrEntity();
		for (DrEntity entity : drList){
			entityAll.setCreatedAmount(entityAll.getCreatedAmount() + entity.getCreatedAmount());
			entityAll.setDccAmount(entityAll.getDccAmount() + entity.getDccAmount());
			entityAll.setAllAmount(entityAll.getAllAmount() + entity.getAllAmount());
			entityAll.setRetailAmount(entityAll.getRetailAmount() + entity.getRetailAmount());
			entityAll.setTwoNetAmount(entityAll.getTwoNetAmount() + entity.getTwoNetAmount());
			entityAll.setBigClientAmount(entityAll.getBigClientAmount() + entity.getBigClientAmount());
			entityAll.setLatentAmount(entityAll.getLatentAmount() + entity.getLatentAmount());
			entityAll.setLatentAssessAmount(entityAll.getLatentAssessAmount() + entity.getLatentAssessAmount());
			entityAll.setLatentAssessDealAmount(entityAll.getLatentAssessDealAmount() + entity.getLatentAssessDealAmount());

			entityAll.setLatentRate(entityAll.getLatentRate() + entity.getLatentRate());
			entityAll.setLatentAssessRate(entityAll.getLatentAssessRate() + entity.getLatentAssessRate());
			entityAll.setLatentAssessDealRate(entityAll.getLatentAssessDealRate() + entity.getLatentAssessDealRate());
			entityAll.setGeneralizedRate(entityAll.getGeneralizedRate() + entity.getGeneralizedRate());
			entityAll.setNarrowlyRate(entityAll.getNarrowlyRate() + entity.getNarrowlyRate());

			entityAll.setSellCreatedAmount(entityAll.getSellCreatedAmount() + entity.getSellCreatedAmount());
			entityAll.setSellDealAmount(entityAll.getSellDealAmount() + entity.getSellDealAmount());
			entityAll.setSellDealRate(entityAll.getSellDealRate() + entity.getSellDealRate());

		}
		entityAll.setYearMonth("合计");
		if (drList.size() > 0) {
			entityAvg.setYearMonth("平均");
			entityAvg.setCreatedAmount(entityAll.getCreatedAmount() / drList.size());
			entityAvg.setDccAmount(entityAll.getDccAmount() / drList.size());
			entityAvg.setAllAmount(entityAll.getAllAmount() / drList.size());
			entityAvg.setRetailAmount(entityAll.getRetailAmount() / drList.size());
			entityAvg.setTwoNetAmount(entityAll.getTwoNetAmount() / drList.size());
			entityAvg.setBigClientAmount(entityAll.getBigClientAmount() / drList.size());
			entityAvg.setLatentAmount(entityAll.getLatentAmount() / drList.size());
			entityAvg.setLatentAssessAmount(entityAll.getLatentAssessAmount() / drList.size());
			entityAvg.setLatentAssessDealAmount(entityAll.getLatentAssessDealAmount() / drList.size());

			entityAvg.setLatentRate((float) ((Math.round((entityAll.getLatentRate() / drList.size())*100))/100));
			entityAvg.setLatentAssessRate((float) ((Math.round((entityAll.getLatentAssessRate() / drList.size())*100))/100));
			entityAvg.setLatentAssessDealRate((float) ((Math.round((entityAll.getLatentAssessDealRate() / drList.size())*100))/100));
			entityAvg.setGeneralizedRate((float) ((Math.round((entityAll.getGeneralizedRate() / drList.size())*100))/100));
			entityAvg.setNarrowlyRate((float) ((Math.round((entityAll.getNarrowlyRate() / drList.size())*100))/100));

			entityAvg.setSellCreatedAmount(entityAll.getSellCreatedAmount() / drList.size());
			entityAvg.setSellDealAmount(entityAll.getSellDealAmount() / drList.size());
			entityAvg.setSellDealRate((float) ((Math.round((entityAll.getSellDealRate() / drList.size())*100))/100));
			drList.add(entityAvg);



			entityAll.setLatentRate(entityAvg.getLatentRate());
			entityAll.setLatentAssessRate(entityAvg.getLatentAssessRate());
			entityAll.setLatentAssessDealRate(entityAvg.getLatentAssessDealRate());
			entityAll.setGeneralizedRate(entityAvg.getGeneralizedRate());
			entityAll.setNarrowlyRate(entityAvg.getNarrowlyRate());
			entityAll.setSellDealRate(entityAvg.getSellDealRate());
		}
		drList.add(entityAll);
		
		PageUtils pageUtil = new PageUtils(drList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:dr:info")
	public R info(@PathVariable("id") Long id){
		DrEntity dr = drService.queryObject(id);
		
		return R.ok().put("dr", dr);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:dr:save")
	public R save(@RequestBody DrEntity dr){
        ValidatorUtils.validateEntity(dr, AddGroup.class);

		Map<String, Object> _params = new HashMap<>();
		_params.put("dealerId", dr.getDealerId());
		_params.put("yearMonth", dr.getYearMonth());
		if(drService.queryObjectByDealerIdAndYearMonth(_params) != null){
			return R.error("该年月已存在，请更换时间！");
		}
		dr.setYear(dr.getYearMonth().split("-")[0]);
		dr.setMonth(dr.getYearMonth().split("-")[1]);
		dr.setCreateDate(DateUtils.getTodayDate());
		dr.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
		dr = calDr(dr);
		drService.save(dr);
		
		return R.ok();
	}

	/**
	 * 上传
	 */
	@RequestMapping("/upload")
	@RequiresPermissions("pm:dr:save")
	public R save(@RequestParam("file") MultipartFile file, HttpServletRequest request){
		String dealerId = request.getParameter("dealerId").toString();
		try {
			// startRowNum是从0开始，1代表忽略第0行。
			List<String[]> lists = ExcelPOIUtils.readExcel(file, 2);
			Map<String, Object> _params = new HashMap<>();
			_params.put("dealerId", dealerId);

			// 忽略第一行 头，i从1开始
			for(int i = 1;i<lists.size();i++){

				String[] datas = lists.get(i);
				if (datas[0] == null || datas[0].equals("")){
					continue;
				}

				int num = 0;
				String yearMonth = DateUtils.format(DateUtils.getDateFrom1900(Integer.valueOf(datas[num++])), "yyyy-MM");
				_params.put("yearMonth", yearMonth);
				DrEntity entity = drService.queryObjectByDealerIdAndYearMonth(_params);
				boolean isAdd = false;
				if (entity == null){
					// 放入实体对象中
					entity = new DrEntity();
					isAdd = true;
				}

				entity.setYearMonth(yearMonth);
				entity.setYear(entity.getYearMonth().split("-")[0]);
				entity.setMonth(entity.getYearMonth().split("-")[1]);

				String amount = datas[num++];
				entity.setCreatedAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
				amount = datas[num++];
				entity.setDccAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
				amount = datas[num++];
				entity.setAllAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
				amount = datas[num++];
				entity.setRetailAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
				amount = datas[num++];
				entity.setTwoNetAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
				amount = datas[num++];
				entity.setBigClientAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
				amount = datas[num++];
				entity.setLatentAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
				amount = datas[num++];
				entity.setLatentAssessAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
				amount = datas[num++];
				entity.setLatentAssessDealAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));

				num++;
				num++;
				num++;
				num++;
				num++;

				amount = datas[num++];
				entity.setSellCreatedAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
				amount = datas[num++];
				entity.setSellDealAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));

				entity = calDr(entity);

				if (isAdd) {
					entity.setCreateDate(DateUtils.getTodayDate());
					entity.setCreateDatetime(DateUtils.getTodayDateYMDHMS());

					drService.save(entity);
				}else {
					drService.update(entity);
				}
			}
		} catch (IOException e) {
			return R.error(e.getMessage());
		}

		return R.ok();
	}

	/**
	 * 计算各种率
	 * @param entity
	 * @return
	 */
	private DrEntity calDr(DrEntity entity){
		entity.setLatentRate(0f);
		if (entity.getCreatedAmount() + entity.getDccAmount() != 0) {
			entity.setLatentRate((float) (entity.getLatentAmount() / (entity.getCreatedAmount() + entity.getDccAmount() + 0.0)));
			entity.setLatentRate((float)(Math.round(entity.getLatentRate()*100))/100);
			entity.setLatentRate(entity.getLatentRate()*100);
		}
		entity.setLatentAssessRate(0f);
		if (entity.getLatentAmount() != 0) {
			entity.setLatentAssessRate((float) (entity.getLatentAssessAmount() / (entity.getLatentAmount() + 0.0)));
			entity.setLatentAssessRate((float)(Math.round(entity.getLatentAssessRate()*100))/100);
			entity.setLatentAssessRate(entity.getLatentAssessRate()*100);
		}
		entity.setLatentAssessDealRate(0f);
		if (entity.getLatentAssessAmount() != 0) {
			entity.setLatentAssessDealRate((float) (entity.getLatentAssessDealAmount() / (entity.getLatentAssessAmount() + 0.0)));
			entity.setLatentAssessDealRate((float)(Math.round(entity.getLatentAssessDealRate()*100))/100);
			entity.setLatentAssessDealRate(entity.getLatentAssessDealRate()*100);
		}


		entity.setGeneralizedRate(0f);
		if (entity.getAllAmount() != 0) {
			entity.setGeneralizedRate((float) (entity.getLatentAssessDealAmount() / (entity.getAllAmount() + 0.0)));
			entity.setGeneralizedRate((float)(Math.round(entity.getGeneralizedRate()*100))/100);
			entity.setGeneralizedRate(entity.getGeneralizedRate()*100);
		}

		entity.setNarrowlyRate(0f);
		if (entity.getRetailAmount() != 0) {
			entity.setNarrowlyRate((float) (entity.getLatentAssessDealAmount() / (entity.getRetailAmount() + 0.0)));
			entity.setNarrowlyRate((float)(Math.round(entity.getNarrowlyRate()*100))/100);
			entity.setNarrowlyRate(entity.getNarrowlyRate()*100);
		}

		entity.setSellDealRate(0f);
		if (entity.getSellCreatedAmount() != 0) {
			entity.setSellDealRate((float) (entity.getSellDealAmount() / (entity.getSellCreatedAmount() + 0.0)));
			entity.setSellDealRate((float)(Math.round(entity.getSellDealRate()*100))/100);
			entity.setSellDealRate(entity.getSellDealRate()*100);
		}

		return entity;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:dr:update")
	public R update(@RequestBody DrEntity dr){
        ValidatorUtils.validateEntity(dr, UpdateGroup.class);
		DrEntity drEntityOld = drService.queryObject(dr.getId());
		if (!dr.getYearMonth().equals(drEntityOld.getYearMonth())){
			// 年月有改变
			Map<String, Object> _params = new HashMap<>();
			_params.put("dealerId", dr.getDealerId());
			_params.put("yearMonth", dr.getYearMonth());

			DrEntity drEntity = drService.queryObjectByDealerIdAndYearMonth(_params);
			if(drEntity != null){
				return R.error("该年月已存在，请更换时间！");
			}
		}
		dr.setYear(dr.getYearMonth().split("-")[0]);
		dr.setMonth(dr.getYearMonth().split("-")[1]);

		dr = calDr(dr);
		drService.update(dr);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:dr:delete")
	public R delete(@RequestBody Long[] ids){
		drService.deleteBatch(ids);
		
		return R.ok();
	}


	/**
	 * 每月各款新车的零售量
	 */
	@RequestMapping("/getsmallcate/{id}/{atype}/{dealerId}")
	@AuthIgnore
	public R getSmallCate(@PathVariable("id") String id,
						  @PathVariable("atype") String atype,
						  @PathVariable("dealerId") String dealerId){

		// 左侧子品牌/车型
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", id);
		List<BasicDataEntity> basicDataList = basicDataService.queryList(map);
		BasicDataEntity allEntity = new BasicDataEntity();
		allEntity.setName("合计");
		allEntity.setId(0L);
		basicDataList.add(allEntity);

		// 上方年月
		map.put("dealerId", dealerId);
		map.put("sidx", "year_month");
		map.put("order", "asc");
		List<DrEntity> drDataList = drService.queryList(map);

		List<List<DraEntity>> _lists = new LinkedList<>();
		List<DraEntity> _listDra;

		// 中间 销售数据，品牌[年月[数量]]
		map.put("atype", atype);
		for (BasicDataEntity bdEntiry : basicDataList){
			map.put("arctic", bdEntiry.getId());
			_listDra = new LinkedList<>();
			for (DrEntity dr : drDataList){
				map.put("yearMonth", dr.getYearMonth());
				DraEntity draEntity = draService.queryObjectByArcticAndYearMonthAndAtypeAndDealerId(map);
				if (draEntity == null){
					draEntity = new DraEntity();
					draEntity.setYearMonth(dr.getYearMonth());
					draEntity.setBrand(bdEntiry.getParentId()+"");
					draEntity.setAtype(Integer.valueOf(atype));
					draEntity.setDealerId(Long.valueOf(dealerId));
					draEntity.setArctic(bdEntiry.getId()+"");
				}
				_listDra.add(draEntity);
			}
			_lists.add(_listDra);
		}

		// 加累计
		List<DraEntity> _listDraAll = new LinkedList<>();
		for (DrEntity dr : drDataList){
			DraEntity draEntityAll = new DraEntity();
			draEntityAll.setAmount(100);
			draEntityAll.setArctic("0");
			_listDraAll.add(draEntityAll);
		}
		_lists.add(_listDraAll);


		return R.ok().put("smallBrandLists", basicDataList).put("yearMonthLists", drDataList).put("amountDataLists", _lists);
	}

	/**
	 * 保存数量
	 */
	@RequestMapping("/savedra")
	@RequiresPermissions("pm:dr:save")
	public R saveDra(@RequestBody DraEntity dra){
		dra.setYear(dra.getYearMonth().split("-")[0]);
		dra.setMonth(dra.getYearMonth().split("-")[1]);
		dra.setCreateDate(DateUtils.getTodayDate());
		dra.setCreateDatetime(DateUtils.getTodayDateYMDHMS());

		Map<String, Object> map = new HashMap<>();
		map.put("dealerId", dra.getDealerId());
		map.put("atype", dra.getAtype());
		map.put("yearMonth", dra.getYearMonth());
		map.put("arctic", dra.getArctic());
		DraEntity draEntity = draService.queryObjectByArcticAndYearMonthAndAtypeAndDealerId(map);
		if (draEntity == null){
			draService.save(dra);
		}else{
			dra.setId(draEntity.getId());
			draService.update(dra);
		}
		return R.ok().put("id", dra.getId());
	}


	/**
	 * 上传数量
	 */
	@RequestMapping("/uploadamount")
	@RequiresPermissions("pm:dr:save")
	public R uploadAmount(@RequestParam("file") MultipartFile file, HttpServletRequest request){
		String dealerId = request.getParameter("dealerId").toString();
		String atype = request.getParameter("atype").toString();
		Map<String, BasicDataEntity> bigCateMap = new HashMap<>();
		List<String> headers = new LinkedList<>();
		try {
			// startRowNum是从0开始，1代表忽略第0行。
			List<String[]> lists = ExcelPOIUtils.readExcel(file, 1);
			Map<String, Object> _params = new HashMap<>();
			_params.put("dealerId", dealerId);
			_params.put("atype", atype);
			Map<String, Object> _bdParams = new HashMap<>();

			String[] headerDatas = lists.get(0);
			for (int h=2; h<headerDatas.length; h++){
				headers.add(DateUtils.format(DateUtils.getDateFrom1900(Integer.valueOf(headerDatas[h])), "yyyy-MM"));
			}

			// 忽略第一行 头，i从1开始
			for(int i = 1;i<lists.size();i++){
				String[] datas = lists.get(i);
				if (datas[0] == null || datas[0].equals("") || datas[1] == null || datas[1].equals("")){
					continue;
				}

				// 寻找大类的id
				BasicDataEntity bdEntity;
				if (bigCateMap.get(datas[0]) == null) {
					bdEntity = basicDataService.queryObjectByName(datas[0]);
					if (bdEntity == null) {
						continue;
					}
					bigCateMap.put(bdEntity.getName(), bdEntity);
				}else{
					bdEntity = bigCateMap.get(datas[0]);
				}

				// 寻找小类的id
				_bdParams.put("parentId", bdEntity.getId());
				_bdParams.put("name", datas[1]);
				BasicDataEntity bdSmallEntity = basicDataService.queryObjectByNameAndParentId(_bdParams);
				if (bdSmallEntity == null){
					continue;
				}

				int num = 2;
				for (int j=2; j<datas.length; j++){
					_params.put("brand", bdEntity.getId());
					_params.put("arctic", bdSmallEntity.getId());
					_params.put("yearMonth", headers.get(j-2));

					DraEntity entity = draService.queryObjectByArcticAndYearMonthAndAtypeAndDealerId(_params);
					boolean isAdd = false;
					if (entity == null){
						// 放入实体对象中
						entity = new DraEntity();
						isAdd = true;
					}

					entity.setYearMonth(_params.get("yearMonth").toString());
					entity.setYear(entity.getYearMonth().split("-")[0]);
					entity.setMonth(entity.getYearMonth().split("-")[1]);

					String amount = datas[num++];
					entity.setAmount((amount.equals("") || amount.equals("null") || amount == null) ? 0 : Integer.valueOf(amount));
					if (amount.equals("") || amount.equals("null") || amount == null){
						continue;
					}
					entity.setArctic(bdSmallEntity.getId()+"");
					entity.setDealerId(Long.valueOf(dealerId));
					entity.setAtype(Integer.valueOf(atype));
					entity.setBrand(bdEntity.getId()+"");

					if (isAdd) {
						entity.setCreateDate(DateUtils.getTodayDate());
						entity.setCreateDatetime(DateUtils.getTodayDateYMDHMS());

						draService.save(entity);
					}else {
						draService.update(entity);
					}

				}
			}
		} catch (IOException e) {
			return R.error(e.getMessage());
		}

		return R.ok();
	}
	
}
