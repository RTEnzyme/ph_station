SELECT
    AVG(avg_temp) AS avgTemp,
    AVG(max_depth) AS avgDepth,
    AVG(avg_speed) AS avgSpeed,
    AVG(storm_days) AS avgStormDays
FROM
    user_proj_rel
        JOIN proj_info ON user_proj_rel.proj_id = proj_info.proj_id
        JOIN location_info ON location_info.location_id = proj_info.location_id
        JOIN met_info ON met_info.met_id = location_info.met_id
WHERE
        user_proj_rel.user_id =1




SELECT
    proj_name as projName,
    proj_type as projType,
    state,
    date,
    design_institute as designInstitute
FROM
    user_proj_rel
    JOIN proj_info ON user_proj_rel.proj_id = proj_info.proj_id
WHERE
    user_proj_rel.user_id =1

SELECT
    *
FROM
    proj_info
        JOIN location_info ON location_info.location_id = proj_info.proj_id
        JOIN met_info ON met_info.met_id = location_info.met_id
WHERE
        proj_id = 1

-----------------


SELECT
    proj_info.proj_id as projId,
    proj_name as projName,
    state,
    owner_id as ownerId,
    design_institute as designInstitute,
    date,
    location_id as locationId
FROM
    user_proj_rel
    JOIN proj_info ON user_proj_rel.proj_id = proj_info.proj_id
WHERE
    user_proj_rel.user_id = 1