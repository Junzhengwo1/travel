package cn.kou.travel.service.impl;

import cn.kou.travel.dao.UserDao;
import cn.kou.travel.dao.impl.UserDaoImpl;
import cn.kou.travel.domain.User;
import cn.kou.travel.service.UserService;
import cn.kou.travel.util.MailUtils;
import cn.kou.travel.util.UuidUtil;

/**
 * @author JIAJUN KOU
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    /**
     * 注册方法
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //根据用户名查询用户对象
        User username = userDao.findByUsername(user.getUsername());
        if(username!=null){
            //用户存在，注册失败
            return false;
        }
        //保存注册用户
        //要设置一下激活码
        user.setCode(UuidUtil.getUuid());
        //设置激活码状态
        user.setStatus("N");
        userDao.save(user);
        //3.激活邮件发送，邮件正文
        String content="<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击激活【俊正我旅游网】</a>";

        MailUtils.sendMail(user.getEmail(),content,"激活邮件");

        return true;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象

        User user=userDao.findByCode(code);
        if(user!=null){
            //2.调用dao的修改激活码状态的方法
            userDao.updateStatus(user);
            return true;
        }else {
            return false;
        }

    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {



        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
