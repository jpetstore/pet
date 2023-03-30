package org.csu.petstoremanage.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.csu.petstoremanage.domain.SignOn;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SignonMapper extends BaseMapper<SignOn> {
}
