<#import "../tags.ftl" as tags>
<#macro show>
<div class="footer">
    <div class="pull-right">
        10GB of <strong>250GB</strong> Free.
    </div>
    <div>
        <strong>Copyright</strong> Example Company &copy; 2014-2015
    </div>
</div>
</div>
</div>
<div id="globalModal" class="modal fade"></div>
<@tags.static.js />
<script>
    var hasActive = '${Session['io.github.gefangshuai.server.constant.session.RestaurantKey'].name!}';
    if(hasActive == ''){
        $.get('/account/additional/${Session['io.github.gefangshuai.server.constant.session.RestaurantKey'].id}', function(data){
            $('#globalModal').html(data).modal('show')
        });
    }
</script>

</body>
</html>
</#macro>