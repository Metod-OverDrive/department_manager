package com.practice.departmentManager.web.mapper;

import com.practice.departmentManager.domain.mailRemind.Remind;
import com.practice.departmentManager.web.dto.mail.RemindDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RemindMapper extends Mappable<Remind, RemindDto>{
}
