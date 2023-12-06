import request from '@/utils/request'

export function upload() {
  return request({
    url: '/upload',
    method: 'post'
  })
}
