/**
 * @title: package-info
 * @projectName core-admin
 * @description: TODO
 * @author hy
 * @date 2024-10-17 18:32:04 18:32
 */
package com.example.core.admin;

//避免空指针 Optional.ofNullable().orElseGet() 写法

/**

Map<Date, PayrollAttendanceMemberDetailVo> detailMap = Optional.ofNullable(details)
    .orElseGet(Collections::emptyList)
    .stream()
    .collect(Collectors.toMap(
        PayrollAttendanceMemberDetailVo::getDate,
        Function.identity(),
        (a, b) -> a
    ));

*/
