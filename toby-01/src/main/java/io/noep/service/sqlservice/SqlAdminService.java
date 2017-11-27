//package io.noep.service.sqlservice;
//
///**
// * Created by Taehoon Yoo
// * User  : taehoon
// * Date  : 2017. 11. 27.
// * Time  : 오후 10:59
// * Page  : http:noep.github.io
// * Email : noep@naver.com
// * Desc  :
// */
//public class SqlAdminService implements AdminEventListener {
//    private UpdatableSqlRegistry updatableSqlRegistry;
//
//    public void setUpdatableSqlRegistry(UpdatableSqlRegistry updatableSqlRegistry) {
//        this.updatableSqlRegistry = updatableSqlRegistry;
//    }
//
//    public void updateEventListener(UpdateEvent event) {
//        this.updatableSqlRegistry.updateSql(event.get(KEY_ID), event.get(SQL_ID));
//    }
//}
