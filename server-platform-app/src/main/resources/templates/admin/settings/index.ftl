<#import "../../tags.ftl" as tags>
<#assign javascript>
<script src="/js/plugins/vue/dist/vue.min.js"></script>
<script src="/js/plugins/vue-resource/dist/vue-resource.min.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {
            progress: 100,
            count: 0
        },
        methods: {
            thumbRebuild: function () {
                $('#thumbRebuild').button('loading');
                var $this = this;
                $this.$http.get('/admin/settings/thumb/rebuild/count').then(function (response) {
                    var $data = response.data;
                    $this.count = $data;

                    $this.$http.get('/admin/settings/thumb/rebuild').then(function(){
                        $this.count = 0;
                        $('#thumbRebuild').button('reset');
                        alert('处理完成!');
                    })
                });
            }
        }
    })
</script>
</#assign>
<@tags.layout.main javascript=javascript>
<div class="row" id="app">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h2>
                    重建缩略图
                    <small class="text-danger">此功能会批量将系统所有的原图生成相关的的缩略图，提高移动端的访问速度.</small>
                </h2>
            </div>
            <div class="ibox-content">
                <div class="progress progress-striped active" v-if="count > 0">
                    <div style="width: {{progress}}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="{{progress}}"
                         role="progressbar" class="progress-bar progress-bar-success">
                        <span class="sr-only">{{progress}}% Complete (success)</span>
                    </div>
                </div>
                <span class="help-block" v-if="count > 0">共{{count}}条记录需要重建，正在处理中...</span>
                <button class="btn btn-primary" type="button" id="thumbRebuild" @click="thumbRebuild"
                        data-loading-text="处理中..."><i class="fa fa-indent"></i> 开始重建
                </button>
            </div>
        </div>
    </div>
</div>
</@tags.layout.main>
