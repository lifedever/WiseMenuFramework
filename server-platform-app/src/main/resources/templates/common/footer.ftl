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

    <#if !Session.restaurant.name?exists>
    <script>
        $.get('/account/additional', function(data){
            $('#globalModal').html(data).modal('show')
        });
    </script>
    </#if>

</body>
</html>
</#macro>