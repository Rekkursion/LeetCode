// 609. Find Duplicate File in System
// Accepted 134ms

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> group = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        
        for(String path: paths) {
            String[] eles = path.trim().split(" {1,}");
            String directory = "";
            String filename = "";
            String fileContent = "";
            List<String> files;
            
            for(String ele: eles) {
                if(ele.length() == 0)
                    continue;
                
                // file
                if(ele.charAt(ele.length() - 1) == ')') {
                    int indexOfOpenParen = ele.indexOf('(');
                    filename = ele.substring(0, indexOfOpenParen);
                    fileContent = ele.substring(indexOfOpenParen + 1, ele.length() - 1);
                    
                    files = group.getOrDefault(fileContent, new ArrayList<String>());
                    files.add(directory + filename);

                    group.put(fileContent, files);
                }
                // directory
                else
                    directory = ele + "/";
            }
        }
        
        group.forEach(
            (fileContent, files) -> {
                if(files.size() > 1)
                    ret.add(files);
            }
        );
        
        return ret;
        //return group.values().stream().collect(Collectors.toList());
    }
}
