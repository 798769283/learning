package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.LMessageVo;
import com.ruoyi.system.domain.LStudentAccount;
import com.ruoyi.system.domain.LTeacherAccount;
import com.ruoyi.system.mapper.LStudentAccountMapper;
import com.ruoyi.system.mapper.LTeacherAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl
 * @ClassName: MesssageService
 * @Author: 胡天霸
 * @Date: 2020/4/29 16:18
 * @Version: 1.0
 */
@Service("message")
public class MesssageService {
    @Autowired
    private LStudentAccountMapper lStudentAccountMapper;

    @Autowired
    private LTeacherAccountMapper lTeacherAccountMapper;

    public List<LMessageVo> getAll(){
        // 1. 获取所有学生账户
        List<LStudentAccount> lStudentAccounts = lStudentAccountMapper.selectLStudentAccountList( new LStudentAccount());
        //2. 获取教师账户
        List<LTeacherAccount> lTeacherAccounts = lTeacherAccountMapper.selectLTeacherAccountList(new LTeacherAccount());
        //3. 创建List
        List<LMessageVo> lMessageVos=new ArrayList<>();
        //4. 循环添加学生
        for (int i=0;i<lStudentAccounts.size();i++){
            LMessageVo lMessageVo = new LMessageVo();
            lMessageVo.setId(lStudentAccounts.get(i).getStudentId());
            lMessageVo.setName(lStudentAccounts.get(i).getName());
            lMessageVos.add(lMessageVo);
        }
        //4. 循环添加老师
        for (int i=0;i<lTeacherAccounts.size();i++){
            LMessageVo lMessageVo = new LMessageVo();
            lMessageVo.setId(lTeacherAccounts.get(i).getTeacherId());
            lMessageVo.setName(lTeacherAccounts.get(i).getUsername());
            lMessageVos.add(lMessageVo);
        }
        return lMessageVos;

    }
}
