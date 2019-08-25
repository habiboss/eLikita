/**
 * 
 */
package models.util;

import java.util.List;

/**
 * @author aboubacar
 *
 * AG Jul 24, 2015
 * @param <T>
 */
public class Page<T> {

		private final int pageSize;
        private final long totalRowCount;
        private final int pageIndex;
        private final List<T> list;
        
        public  Page(List<T> data, long total, int page, int pageSize) {
            this.list = data;
            this.totalRowCount = total;
            this.pageIndex = page;
            this.pageSize = pageSize;
        }
        
        public long getTotalRowCount() {
            return totalRowCount;
        }
        
        public int getPageIndex() {
            return pageIndex;
        }
        
        public List<T> getList() {
            return list;
        }
        
        public boolean hasPrev() {
            return pageIndex > 1;
        }
        
        public boolean hasNext() {
            return (totalRowCount/pageSize) >= pageIndex;
        }
        
        public String getDisplayXtoYofZ() {
            int start = ((pageIndex - 1) * pageSize + 1);
            int end = start + Math.min(pageSize, list.size()) - 1;
            return start + " to " + end + " of " + totalRowCount;
        }
        
        public String getDisplayXtoYofZ(String str1, String str2) {
            int start = ((pageIndex - 1) * pageSize + 1);
            if(totalRowCount==0) start=0;
            int end = start + Math.min(pageSize, list.size()) - 1;
            if(totalRowCount==0) start = end = 0;
            return start + str1 + end + str2 + totalRowCount;
        }

	}
