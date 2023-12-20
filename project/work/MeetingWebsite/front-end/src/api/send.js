import request from '@/utils/request'


export function add(people) {
  return request({
    url: '/send',
    method: 'post',
    data: people
  })
}

export function update(people) {
  return request({
    url: '/send',
    method: 'put',
    data: people
  })
}




