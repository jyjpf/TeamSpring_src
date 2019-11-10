<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div>
		    <div style="padding:20px">
		        <span style="font-size: 2em;">Customer</span>
		    </div>
		    <div style="border:1px solid black; padding:15px; margin: 5px; height:400px; ">
		        <div>
		            <table style="text-align:center; padding:10px; margin:10px">
		                <tbody>
		                    <tr>
		                        <td>Customer</td>
		                        <td>${customerVO.title}</td>
		                    </tr>
		                    <tr>
		                        <td>Customer Code</td>
		                        <td>${customerVO.cus_cd}</td>
		                    </tr>
		                    <tr>
		                        <td>Business License Number</td>
		                        <td>${empty customerVO.reg_cd ? "" : customerVO.reg_cd}</td>
		                    </tr>
		                    <tr>
		                        <td>FAX</td>
		                        <td>${empty customerVO.fax ? "" : customerVO.fax}</td>
		                    </tr>
		                    <tr>
		                        <td>Domain</td>
		                        <td>${empty customerVO.domain ? "" : customerVO.domain}</td>
		                    </tr>
		                    <tr>
		                        <td>CEO</td>
		                        <td>${empty customerVO.ceo_name ? "" : customerVO.ceo_name}</td>
		                    </tr>
		                    <tr>
		                        <td>CEO E-mail</td>
		                        <td>${empty customerVO.ceo_email ? "" : customerVO.ceo_email}</td>
		                    </tr>
		                    <tr>
		                        <td>Worker</td>
		                        <td>${empty customerVO.worker_name ? "" : customerVO.worker_name}</td>
		                    </tr>
		                    <tr>
		                        <td>Worker E-mail</td>
		                        <td>${empty customerVO.worker_email ? "" : customerVO.worker_email}</td>
		                    </tr>
		                </tbody>
		            </table>
		        </div>
		        <div style="float:right;">
		            <input type="button" style="margin:5px" class="button" value="MODIFY" onclick="location.href='/kaikei/account/customerModify.do?cus_cd=${customerVO.cus_cd}'">
		            <input type="button" style="margin:5px" class="button" value="DELETE" onclick="isDelete();">
		        </div>
		    </div>
		</div>
		<script>
			function isDelete() {
				if(confirm("Are you sure?")) {
					location.href='/kaikei/account/customerDelete.do?cus_cd=${customerVO.cus_cd}';
					return true;
				}

				return false;
			}

		</script>