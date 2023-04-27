package com.learningsec.pro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningsec.pro.Model.CommonResponse;
import com.learningsec.pro.Model.ModuleDocMaster;
import com.learningsec.pro.Model.ModuleMaster;
import com.learningsec.pro.Model.Project;
import com.learningsec.pro.Utility.ImageUtility;

@RestController
@RequestMapping("/Module")
public class ModuleController {

	@Autowired
	CommonResponse response;
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	@RequestMapping(value="/getModule",method = RequestMethod.GET)
	public ModuleMaster addModule() {
		ModuleMaster moduleMaster = new ModuleMaster();
		ModuleDocMaster docMaster = new ModuleDocMaster();
		
		List<ModuleDocMaster> list = new ArrayList<>();
		
		list.add(docMaster);
		moduleMaster.setModuleDocList(list);
		return moduleMaster;
	}
	
	
	public ModuleMaster addModule(@RequestParam("files") MultipartFile[] files, @RequestParam("data") String moduleData) {
		
		ModuleMaster moduleMaster = new ModuleMaster();
		
		try {
			moduleMaster = objectMapper.readValue(moduleData, ModuleMaster.class);
			List<ModuleDocMaster> fileList = new ArrayList<>();

		}catch (Exception e) {
			setResponse(e.getMessage(), "Failed", moduleData);
			return moduleMaster;
		}
		
		return null;
	}
	
	
	public void setResponse(String status,String message,String data) {
		response.setMessage(message);
		response.setStatus(status);
		response.setData(data);
	}
	
}
