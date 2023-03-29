package org.csu.petstoremanage.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.csu.petstoremanage.domain.items;
@Mapper
public interface itemMappers extends BaseMapper<items> {
}
