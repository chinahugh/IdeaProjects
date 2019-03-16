package springboot.com.mvc.mapper;

import springboot.com.mvc.entity.MapperParameterType;
import springboot.com.mvc.entity.MapperResultType;
import springboot.com.mvc.entity.XmMainDay;
import springboot.template.mvc.mapper.BaseMapper;

import java.util.List;


public interface XmMainDayMapper extends BaseMapper<XmMainDay> {
    List<MapperResultType> count(MapperParameterType parameterType);
}