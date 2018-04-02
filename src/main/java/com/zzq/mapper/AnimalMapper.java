package com.zzq.mapper;

import com.zzq.entity.Animal;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zzq
 * @createTime 2018/4/1
 */
@Mapper
@Repository
public interface AnimalMapper {
    @Select("select * from animal where id = #{id}")
    Animal findAnimalById(@Param("id") Integer id);

    @Insert("insert into animal(name, sex, age) values(#{name}, #{sex}, #{age})")
    int insert(Animal animal);

    @Update("update animal set name=#{name}, sex=#{sex}, age=#{age} where id=#{id}")
    void update(Animal animal);

    @Delete("delete from animal where id=#{id}")
    void delete(Integer id);

    /**
     * @Result中的property属性对应Animal对象中的成员名，column对应SELECT出的字段名
     * 如果两个的名称一致，则不用另外指定
     */
/*    @Results({
            @Result(property = "name", column="name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age", column = "age")
    })*/
    @Select("select name, sex, age from animal")
    List<Animal> findAll();

    @Insert("insert into animal(name, sex, age) values(" +
            "#{name, jdbcType=VARCHAR}, #{sex, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

}
