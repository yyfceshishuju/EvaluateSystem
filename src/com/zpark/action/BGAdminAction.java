package com.zpark.action;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.entity.Admin;
import com.zpark.entity.Assistant;
import com.zpark.entity.Teacher;
import com.zpark.service.AdminService;
import com.zpark.service.RoleService;

@Controller
@Scope("prototype")
public class BGAdminAction extends ActionSupport {

	private Logger logger = Logger.getLogger(BGAdminAction.class);

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Autowired
	private AdminService adminService;
	@Autowired
	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	// 管理员登陆收集的参数
	private String username;
	private String password;
	private String role;
	// 修改密码需要收集的数据
	private String oldPassword;
	private String newPassword1;
	private String assisOldPassword;
	private String assisNewPassword;

	public String getAssisOldPassword() {
		return assisOldPassword;
	}

	public void setAssisOldPassword(String assisOldPassword) {
		this.assisOldPassword = assisOldPassword;
	}

	public String getAssisNewPassword() {
		return assisNewPassword;
	}

	public void setAssisNewPassword(String assisNewPassword) {
		this.assisNewPassword = assisNewPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 方法的描述:管理员登陆功能
	 * 
	 * @return: String
	 */
	public String login() {
		logger.info("--------[ into login method ]-------");
		if ("manager".equals(role)) {
			logger.info("管理员登录");
			Admin admin = adminService.queryAdminByUsername(username);
			try {
				if (password.equals(admin.getPassword())) {

					ActionContext.getContext().getSession()
							.put("nowAdminId", admin.getId());
					return "loginSuccess";
				}
			} catch (Exception e) {
				return "loginFail";
			}
		}
		if ("teacher".equals(role)) {
			logger.info("讲师登录");
			try {
				Teacher t = roleService.teacherLogin(username, password);
				System.out.println(t + "=====================");
				if (t != null) {
					ActionContext.getContext().getSession().put("teacher", t);
					ActionContext.getContext().getSession().put("role", "teacher");
					return "teacherLoginSuccess";
				}
			} catch (Exception e) {
				return "loginFail";
			}
		}
		if ("assistant".equals(role)) {
			logger.info("项目经理");
			try {
				Assistant a = roleService.assistantLogin(username, password);
				if (a != null) {
					ActionContext.getContext().getSession().put("assistant", a);
					ActionContext.getContext().getSession().put("role", "assistant");
					return "assistantLoginSuccess";
				}
			} catch (Exception e) {
				return "loginFail";
			}
		}
		return "loginFail";
	}

	/**
	 * 功能：讲师密码修改功能
	 * 
	 * @return
	 */
	public String teacherModifyPassword() {
		Teacher t = (Teacher) ActionContext.getContext().getSession()
				.get("teacher");
		try {
			roleService.teacherModifyPassword(t.getId(), oldPassword,
					newPassword1);
		} catch (Exception e) {
			return "teacherModifyPasswordFail";
		}
		return "teacherModifyPassword";
	}

	/**
	 * 功能：助教密码修改功能
	 * 
	 * @return
	 */
	public String assistantModifyPassword() {
		Assistant a = (Assistant) ActionContext.getContext().getSession()
				.get("assistant");
		try {
			roleService.assistantModifyPassword(a.getId(), assisOldPassword,
					assisNewPassword);
		} catch (Exception e) {
			return "assistantModifyPasswordFail";
		}
		return "assistantModifyPassword";
	}
}
