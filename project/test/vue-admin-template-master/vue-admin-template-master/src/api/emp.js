import request from '@/utils/request'

export function page(name,gender,begin,end,page,pageSize) {
  return request({
    url: '/emps?name='+name+'&gender='+gender+'&begin='+begin+'&end='+end+'&page='+page+'&pageSize='+pageSize,
    method: 'get'
  })
}

export function add(emp) {
  return request({
    url: '/emps',
    method: 'post',
    data: emp
  })
}

export function update(dept) {
  return request({
    url: '/emps',
    method: 'put',
    data: dept
  })
}


export function deleteById(id) {
  return request({
    url: '/emps/'+id,
    method: 'delete',
  })
}


export function selectById(id) {
  return request({
    url: '/emps/'+id,
    method: 'get',
  })
}

