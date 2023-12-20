import request from '@/utils/request'

export function getIndexData() {
  return request({
    url: '/index',
    method: 'get'
  })
}