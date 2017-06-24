package cn.study.service;

import cn.study.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.study.domain.User;

@Service
public class HrmService implements IHrmService {
    @Autowired
    private IUserDao userDao;

    public User find(){
        return null;
    }

    public void save() throws Exception{
        this.userDao.save();
    }
}
