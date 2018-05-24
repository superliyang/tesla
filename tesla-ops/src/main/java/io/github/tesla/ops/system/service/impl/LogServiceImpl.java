package io.github.tesla.ops.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.tesla.ops.system.dao.LogDao;
import io.github.tesla.ops.system.domain.LogDO;
import io.github.tesla.ops.system.domain.PageDO;
import io.github.tesla.ops.system.service.LogService;
import io.github.tesla.ops.utils.Query;

@Service
public class LogServiceImpl implements LogService {
  @Autowired
  LogDao logMapper;

  @Override
  public PageDO<LogDO> queryList(Query query) {
    int total = logMapper.count(query);
    List<LogDO> logs = logMapper.list(query);
    PageDO<LogDO> page = new PageDO<>();
    page.setTotal(total);
    page.setRows(logs);
    return page;
  }

  @Override
  public int remove(Long id) {
    int count = logMapper.remove(id);
    return count;
  }

  @Override
  public int batchRemove(Long[] ids) {
    return logMapper.batchRemove(ids);
  }
}
