package cn.study.service;


import cn.study.domain.User;

public interface IHrmService {
    public User find() throws Exception;
    public void save() throws Exception;
}
