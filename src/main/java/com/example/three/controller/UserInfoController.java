package com.example.three.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.three.bean.entity.UserInfo;
import com.example.three.service.SysRoleService;
import com.example.three.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by admin on 2017/8/11.
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 用户查询.
	 *
	 * @return
	 */
	@RequiresPermissions("userInfo:view")
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userInfo(Page<UserInfo> page, Model model) {

		model.addAttribute("page", userInfoService.selectUserPage(page));
		return "userInfo";
	}

	/**
	 * 用户添加;
	 *
	 * @return
	 */
	@RequiresPermissions("userInfo:add")
	@RequestMapping(value = "/userAdd", method = RequestMethod.GET)
	public String userInfoAdd(Model model) {

		model.addAttribute("roleList", sysRoleService.selectRoleList());
		return "userInfoAdd";
	}

	/**
	 * 用户编辑
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String userInfoRevise(Model model, @PathVariable(value = "id") long id) {

		model.addAttribute("user", userInfoService.userInfoRevise(id));
		model.addAttribute("roleList", sysRoleService.selectRoleList());
		return "userInfoAdd";
	}

	/**
	 * 用户删除;
	 *
	 * @return
	 */
	@RequestMapping(value = "/userDel", method = RequestMethod.DELETE)
	@RequiresPermissions("userInfo:del")
	public String userDel() {
		return "userInfoDel";
	}

	/**
	 * 用户保存（新增）
	 *
	 * @return
	 */
	@RequestMapping(value = "/userSave", method = RequestMethod.POST)
	public String userInfoAddSave(UserInfo userInfo) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		userInfoService.insertUser(userInfo);
		return "redirect:/userInfo/userList";
	}

	/**
	 * 用户保存（编辑）
	 *
	 * @return
	 */
	@RequestMapping(value = "/userSave", method = RequestMethod.PUT)
	public String userInfoReviseSave(UserInfo userInfo) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		userInfoService.reviseUser(userInfo);
		return "redirect:/userInfo/userList";
	}

}
