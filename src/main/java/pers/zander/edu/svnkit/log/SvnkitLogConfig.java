package pers.zander.edu.svnkit.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNLogClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class SvnkitLogConfig {
	/*
	 * 第二步：声明客户端管理类SVNClientManager。
	 */
	private static SVNClientManager ourClientManager;
//
//	public static void main(String[] args) {
//		/*
//		 * 第三步： 对版本库进行初始化操作 (在用版本库进行其他操作前必须进行初始化) 对于通过使用 http:// 和 https://
//		 * 访问，执行DAVRepositoryFactory.setup(); 对于通过使用svn:// 和
//		 * svn+xxx://访问，执行SVNRepositoryFactoryImpl.setup();
//		 * 对于通过使用file:///访问，执行FSRepositoryFactory.setup(); 本程序框架用svn://来访问
//		 */
//
//		SVNRepositoryFactoryImpl.setup();
//		/*
//		 * 第四步： 要访问版本库的相关变量设置
//		 */
//		// 版本库的URL地址
//		SVNURL repositoryURL = null;
//		try {
//			repositoryURL = SVNURL.parseURIEncoded("svn://localhost/testRep");
//		} catch (SVNException e) {
//			//
//		}
//		// 版本库的用户名
//		String name = "userName";
//		// 版本库的用户名密码
//		String password = "userPassword";
//		// 驱动选项
//		ISVNOptions options = SVNWCUtil.createDefaultOptions(true);
//		/*
//		 * 第五步： 创建SVNClientManager的实例。提供认证信息（用户名，密码） 和驱动选项。
//		 */
//		ourClientManager = SVNClientManager.newInstance(
//				(DefaultSVNOptions) options, name, password);
//		/*
//		 * 第六步： 通过SVNClientManager的实例获取要进行操作的client实例（如 * SVNUpdateClient）
//		 * 通过client实例来执行相关的操作。 此框架以check out操作来进行说明，其他操作类似。
//		 */
//
//
//		try {
//			/*
//			 * 递归的把工作副本从repositoryURL check out 到 wcDir目录。 SVNRevision.HEAD
//			 * 意味着把最新的版本checked out出来。
//			 */
//			SVNLogClient logClient = ourClientManager.getLogClient();
//			File f= new File("D://mysvnlog/svnlog.txt") ; // 声明File对象
//			  // 第2步、通过子类实例化父类对象
//			  OutputStream out = null ; // 准备好一个输出的对象
//			  out = new FileOutputStream(f);  
//			logClient.setIgnoreExternals(false);
//			byte b[] = new byte[1024] ;
//			out.write(b);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
